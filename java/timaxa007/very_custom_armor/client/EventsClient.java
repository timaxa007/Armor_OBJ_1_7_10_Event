package timaxa007.very_custom_armor.client;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import timaxa007.very_custom_armor.MyMod;

public class EventsClient {

	public static int[] displayList = new int[10];//for 10 parts model

	public EventsClient() {

		final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation(MyMod.MODID, "model/armor/armor_plane.obj"));
		//ModelRenderer.compileDisplayList(float)
		final String[] partsName = new String[] {
				"helm",			//1
				"glass",		//2
				"body",			//3
				"plane",		//4
				"right_arm",	//5
				"left_arm",		//6
				"right_leg",	//7
				"left_leg",		//8
				"right_boot",	//9
				"left_boot"		//10
		};
		for (int i = 0; i < displayList.length; ++i ) {
			displayList[i] = GLAllocation.generateDisplayLists(1);
			GL11.glNewList(displayList[i], GL11.GL_COMPILE);
			model.renderPart(partsName[i]);
			GL11.glEndList();
		}

	}

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

	public static ArmorCustomModel getModel(EntityLivingBase entityPlayer, ItemStack stack, int slot) {
		if (stack.getItem() == MyMod.armorHelmet) return acm0;
		else if (stack.getItem() == MyMod.armorVest) return acm1;
		else if (stack.getItem() == MyMod.armorPants) return acm2;
		else if (stack.getItem() == MyMod.armorBoots) return acm3;
		else return null;
	}

}
