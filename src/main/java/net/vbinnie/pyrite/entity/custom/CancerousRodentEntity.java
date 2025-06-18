package net.vbinnie.pyrite.entity.custom;


import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;
import net.vbinnie.pyrite.effect.ModEffects;
import net.vbinnie.pyrite.entity.ModEntities;
import org.jetbrains.annotations.Nullable;

public class CancerousRodentEntity extends TameableEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public CancerousRodentEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }


    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));

        this.goalSelector.add(3, new AnimalMateGoal(this, 0.5));


        this.goalSelector.add(2, new FollowOwnerGoal(this, 0.5, 2, 30, true));



        this.goalSelector.add(1, new EatGrassGoal(this));
        this.goalSelector.add(4, new FollowParentGoal(this, 0.25));
        this.goalSelector.add(5, new TemptGoal(this, 0.25, Ingredient.ofItems(Items.ROTTEN_FLESH), false));
        this.goalSelector.add(6, new LookAroundGoal(this));
        
        this.goalSelector.add(8, new GoToVillageGoal(this, 200));
        this.goalSelector.add(9, new WanderAroundFarGoal(this, 0.25));


        this.goalSelector.add(10, new LookAtEntityGoal(this, PlayerEntity.class, 4));


    }


    public static DefaultAttributeContainer.Builder createAttribute() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 5)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 10)
                .add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 40;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {

            this.setupAnimationStates();
        }
        else {
            this.applyEffectesRealNotFake();

        }
    }



    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        Item item = itemStack.getItem();
        if (this.isTamed()) {
            if (this.isOwner(player)) {
                if (this.isBreedingItem(itemStack) && this.getHealth() < this.getMaxHealth()) {
                    if (!this.getWorld().isClient()) {
                        this.eat(player, hand, itemStack);
                        FoodComponent foodComponent =itemStack.getItem().getFoodComponent();
                        this.heal(foodComponent != null ? (float)foodComponent.getHunger() : 1.0F);
                    }

                    return ActionResult.success(this.getWorld().isClient());
                }

                ActionResult actionResult = super.interactMob(player, hand);
                if (!actionResult.isAccepted()) {
                    this.setSitting(!this.isSitting());
                    return ActionResult.success(this.getWorld().isClient());
                }

                return actionResult;
            }
        } else if (this.isBreedingItem(itemStack)) {
            if (!this.getWorld().isClient()) {
                this.eat(player, hand, itemStack);
                this.tryTame(player);
                this.heal(4);
                this.setPersistent();
            }
            else if (Items.SHEARS == itemStack.getItem()) {
                // add rodent hair drop
            }

            return ActionResult.success(this.getWorld().isClient());
        }

        else if (!this.isBreedingItem(itemStack)) {
            this.setSitting(true);
        }

        ActionResult actionResult = super.interactMob(player, hand);
        if (actionResult.isAccepted()) {
            this.setPersistent();
        }

        return actionResult;
    }



    private void applyEffectesRealNotFake() {
        addStatusEffect(new StatusEffectInstance(ModEffects.CANCERIMMUNITY.value(), 9999, 0, false, false));
        addStatusEffect(new StatusEffectInstance(ModEffects.RADIOACTIVE.value(), 9999, 0, false, false));
        addStatusEffect(new StatusEffectInstance(ModEffects.CANCER.value(), 9999, 0, false, false));
    }

    @Override
    public boolean shouldRenderName() {
        return false;
    }



    private void tryTame(PlayerEntity player) {
        if (this.random.nextInt(3) == 0) {
            this.setOwner(player);
            this.setSitting(true);
            this.getWorld().sendEntityStatus(this, (byte)7);
        } else {
            this.getWorld().sendEntityStatus(this, (byte)6);
        }

    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.ROTTEN_FLESH);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.CANCEROUS_RODENT.create(world);
    }

    @Override
    public EntityView method_48926() {
        return getWorld();
    }
}
