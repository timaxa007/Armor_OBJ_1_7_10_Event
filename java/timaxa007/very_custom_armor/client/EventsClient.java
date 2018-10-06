package timaxa007.very_custom_armor.client;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderPlayerEvent;
import timaxa007.very_custom_armor.MyMod;

public class EventsClient {

	@SubscribeEvent
	public void onRenderArmomForPlayer(RenderPlayerEvent.SetArmorModel event) {
		if (event.stack == null) return;
		ArmorCustomModel acm = getModel(event.entityPlayer, event.stack, event.slot);
		if (acm == null) return;
		acm.partHead.set(event.renderer.modelBipedMain.bipedHead);
		acm.partBody.set(event.renderer.modelBipedMain.bipedBody);
		acm.partRightArm.set(event.renderer.modelBipedMain.bipedRightArm);
		acm.partLeftArm.set(event.renderer.modelBipedMain.bipedLeftArm);
		acm.partRightLeg.set(event.renderer.modelBipedMain.bipedRightLeg);
		acm.partLeftLeg.set(event.renderer.modelBipedMain.bipedLeftLeg);
		acm.render(event.entityPlayer);
	}

	private static final ArmorCustomModel
	acm0 = new ArmorCustomModelTest(0),
	acm1 = new ArmorCustomModelTest(1),
	acm2 = new ArmorCustomModelTest(2),
	acm3 = new ArmorCustomModelTest(3);

	public ArmorCustomModel getModel(EntityLivingBase entityPlayer, ItemStack stack, int slot) {
		if (stack.getItem() == MyMod.armorHelmet) return acm0;
		else if (stack.getItem() == MyMod.armorVest) return acm1;
		else if (stack.getItem() == MyMod.armorPants) return acm2;
		else if (stack.getItem() == MyMod.armorBoots) return acm3;
		else return null;
	}

}
