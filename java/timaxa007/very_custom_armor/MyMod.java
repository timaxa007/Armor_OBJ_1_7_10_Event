package timaxa007.very_custom_armor;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;

@Mod(modid = MyMod.MODID, name = MyMod.NAME, version = MyMod.VERSION)
public class MyMod {

	public static final String
	MODID = "very_custom_armor",
	NAME = "Very Custom Armor",
	VERSION = "0.4.7";

	@Mod.Instance(MODID) public static MyMod instance;

	@SidedProxy(modId = MODID,
			serverSide = "timaxa007.very_custom_armor.ProxyCommon",
			clientSide = "timaxa007.very_custom_armor.client.ProxyClient")
	public static ProxyCommon proxy;

	public static Item
	armorHelmet,
	armorVest,
	armorPants,
	armorBoots;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		armorHelmet = new ItemCustomArmor(ArmorMaterial.IRON, 0).setUnlocalizedName("armor_helmet").setTextureName(MODID + ":armor_helmet").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(armorHelmet, "armor_helmet");

		armorVest = new ItemCustomArmor(ArmorMaterial.IRON, 1).setUnlocalizedName("armor_vest").setTextureName(MODID + ":armor_vest").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(armorVest, "armor_vest");

		armorPants = new ItemCustomArmor(ArmorMaterial.IRON, 2).setUnlocalizedName("armor_pants").setTextureName(MODID + ":armor_pants").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(armorPants, "armor_pants");

		armorBoots = new ItemCustomArmor(ArmorMaterial.IRON, 3).setUnlocalizedName("armor_boots").setTextureName(MODID + ":armor_boots").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(armorBoots, "armor_boots");

		proxy.preInit();
	}

}
