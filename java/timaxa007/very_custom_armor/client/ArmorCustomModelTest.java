package timaxa007.very_custom_armor.client;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import timaxa007.very_custom_armor.MyMod;

@SideOnly(Side.CLIENT)
public class ArmorCustomModelTest extends ArmorCustomModel {

	public static final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation(MyMod.MODID, "model/armor/armor_plane.obj"));
	public static final ResourceLocation
	texture_glass = new ResourceLocation("textures/blocks/glass_white.png"),
	texture_wood = new ResourceLocation("textures/blocks/planks_oak.png");
	private final int partType;

	/**armorType: 0 - head, 1 - body and arms, 2 - legs, 3 - feet.**/
	public ArmorCustomModelTest(int armorType) {
		partType = armorType;
	}

	@Override
	public void pre() {
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		//Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationBlocksTexture);
	}

	@Override
	public void post() {
		GL11.glDisable(GL11.GL_BLEND);
	}

	@Override
	public void partHead() {
		if (partType == 0) {
			GL11.glTranslatef(0F, -1.5F, 0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture_wood);
			model.renderPart("helm");
			Minecraft.getMinecraft().renderEngine.bindTexture(texture_glass);
			model.renderPart("glass");
		}
	}

	@Override
	public void partBody() {
		Minecraft.getMinecraft().renderEngine.bindTexture(texture_wood);
		if (partType == 1) {
			GL11.glTranslatef(0F, -1.5F, 0F);
			model.renderPart("body");
			model.renderPart("plane");
		}
	}

	@Override
	public void partRightArm() {
		if (partType == 1) {
			GL11.glTranslatef(0.3125F, -1.375F, 0F);
			model.renderPart("right_arm");
		}
	}

	@Override
	public void partLeftArm() {
		if (partType == 1) {
			GL11.glTranslatef(-0.3125F, -1.375F, 0F);
			model.renderPart("left_arm");
		}
	}

	@Override
	public void partRightLeg() {
		GL11.glTranslatef(0.125F, -0.75F, 0F);
		if (partType == 2)
			model.renderPart("right_leg");
		if (partType == 3)
			model.renderPart("right_boot");
	}

	@Override
	public void partLeftLeg() {
		GL11.glTranslatef(-0.125F, -0.75F, 0F);
		if (partType == 2)
			model.renderPart("left_leg");
		if (partType == 3)
			model.renderPart("left_boot");
	}

}
