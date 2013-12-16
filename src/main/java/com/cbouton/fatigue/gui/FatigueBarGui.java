package com.cbouton.fatigue.gui;

import org.lwjgl.opengl.GL11;

import com.cbouton.fatigue.handlers.FatigueHandler;
import com.cbouton.fatigue.handlers.FatiguePacketHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;

public class FatigueBarGui extends Gui {
	public Minecraft minecraft;

	public FatigueBarGui(Minecraft mc) {
		this.minecraft = mc;
	}

	// Render this overlay after the xp bar is drawn
	@ForgeSubscribe(priority = EventPriority.NORMAL)
	public void onRenderExperienceBar(RenderGameOverlayEvent event) {
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE) {
			return;
		}
		if (minecraft.thePlayer.capabilities.isCreativeMode){
			return;
		}

		int x = 5;
		int y = 5;

		// The string version of the fatigue to be rendered to the HUD
		String fatiguePercentage = Integer.toString((FatiguePacketHandler
				.getFatigue() * 100) / 65535) + "%";

		FontRenderer fontRender = minecraft.fontRenderer;

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);

		// this.minecraft.renderEngine.bindTexture(new ResourceLocation(""));

		int color = 0xFFFFFF;
		fontRender.drawStringWithShadow(fatiguePercentage, x, y, color);
	}

}
