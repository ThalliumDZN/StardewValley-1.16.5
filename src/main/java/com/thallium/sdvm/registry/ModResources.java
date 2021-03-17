package com.thallium.sdvm.registry;

import com.thallium.sdvm.StardewValley;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;

import java.io.InputStream;

public class ModResources
{
    public static void registerResources()
    {
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new SimpleSynchronousResourceReloadListener()
        {
            @Override
            public Identifier getFabricId()
            {
                return new Identifier("sdvm", "prices");
            }

            @Override
            public void apply(ResourceManager manager)
            {
                //Clear caches here

                for (Identifier id: manager.findResources("sdvm", s -> s.endsWith(".json")))
                {
                    try (InputStream stream = manager.getResource(id).getInputStream())
                    {
                        //Consume the stream however you want
                    } catch (Exception e)
                    {
                        StardewValley.LOGGER.error("Error occurred while loading priceList json" + id.toString(), e);
                    }
                }
            }
        });
    }
}
