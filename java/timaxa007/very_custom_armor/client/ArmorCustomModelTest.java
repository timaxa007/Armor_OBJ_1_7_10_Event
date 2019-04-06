package timaxa007.very_custom_armor.client;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class ArmorCustomModelTest extends ArmorCustomModel {

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
			GL11.glCallList(EventsClient.displayList[0]);
			Minecraft.getMinecraft().renderEngine.bindTexture(texture_glass);
			GL11.glCallList(EventsClient.displayList[1]);
		}
	}

	@Override
	public void partBody() {
		Minecraft.getMinecraft().renderEngine.bindTexture(texture_wood);
		if (partType == 1) {
			GL11.glTranslatef(0F, -1.5F, 0F);
			GL11.glCallList(EventsClient.displayList[2]);
			GL11.glCallList(EventsClient.displayList[3]);
		}
	}

	@Override
	public void partRightArm() {
		if (partType == 1) {
			GL11.glTranslatef(0.3125F, -1.375F, 0F);
			GL11.glCallList(EventsClient.displayList[4]);
		}
	}

	@Override
	public void partLeftArm() {
		if (partType == 1) {
			GL11.glTranslatef(-0.3125F, -1.375F, 0F);
			GL11.glCallList(EventsClient.displayList[5]);
		}
	}

	@Override
	public void partRightLeg() {
		GL11.glTranslatef(0.125F, -0.75F, 0F);
		if (partType == 2)
			GL11.glCallList(EventsClient.displayList[6]);
		if (partType == 3)
			GL11.glCallList(EventsClient.displayList[8]);
	}

	@Override
	public void partLeftLeg() {
		GL11.glTranslatef(-0.125F, -0.75F, 0F);
		if (partType == 2)
			GL11.glCallList(EventsClient.displayList[7]);
		if (partType == 3)
			GL11.glCallList(EventsClient.displayList[9]);
	}

}
