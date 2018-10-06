package timaxa007.very_custom_armor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public abstract class ItemCustomArmorDummy extends ItemArmor {

	public ItemCustomArmorDummy(ItemArmor.ArmorMaterial material, int armorType) {
		super(material, 1, armorType);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
		ModelBiped model = new ModelBiped();
		model.bipedHead.showModel = 
				model.bipedHeadwear.showModel = 
				model.bipedBody.showModel = 
				model.bipedRightArm.showModel = 
				model.bipedLeftArm.showModel = 
				model.bipedRightLeg.showModel = 
				model.bipedLeftLeg.showModel = false;
		return model;
	}

}
