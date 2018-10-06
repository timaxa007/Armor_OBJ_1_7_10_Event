package timaxa007.very_custom_armor.client;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.very_custom_armor.ProxyCommon;

public class ProxyClient extends ProxyCommon {

	public void preInit() {
		super.preInit();
		MinecraftForge.EVENT_BUS.register(new EventsClient());
	}

}
