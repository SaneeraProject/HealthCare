package com.health.launcher;

import java.awt.Color;
import java.awt.Font;

import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.MetalTheme;

public class CMOSTheme extends MetalTheme {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "CMOS Theme";
	}

	@Override
	public ColorUIResource getControlDisabled() {
		return new ColorUIResource(Color.decode("#224488"));
	}

	@Override
	public ColorUIResource getInactiveControlTextColor() {
		return new ColorUIResource(Color.decode("#224488"));
	}

	@Override
	public ColorUIResource getMenuDisabledForeground() {
		return new ColorUIResource(Color.decode("#224488"));
	}
	
	@Override
	public ColorUIResource getWindowTitleBackground() {
		return new ColorUIResource(Color.decode("#224488"));
	}

	@Override
	protected ColorUIResource getPrimary1() {
		return new ColorUIResource(Color.decode("#9FA7BD"));
	}

	@Override
	protected ColorUIResource getPrimary2() {
		return new ColorUIResource(Color.decode("#eeeeee"));
	}

	@Override
	protected ColorUIResource getPrimary3() {
		return new ColorUIResource(Color.decode("#dddddd"));
	}

	@Override
	protected ColorUIResource getSecondary1() {
		return new ColorUIResource(Color.decode("#bbbbbb"));
	}

	@Override
	protected ColorUIResource getSecondary2() {
		return new ColorUIResource(Color.decode("#cccccc"));
	}

	@Override
	protected ColorUIResource getSecondary3() {
		return new ColorUIResource(244, 244, 244);
	}

	@Override
	public FontUIResource getControlTextFont() {
		return new FontUIResource(new Font("Arial", Font.PLAIN, 12));
	}

	@Override
	public FontUIResource getSystemTextFont() {
		return new FontUIResource(Font.SANS_SERIF, Font.PLAIN, 12);
	}

	@Override
	public FontUIResource getUserTextFont() {
		return new FontUIResource(Font.SANS_SERIF, Font.PLAIN, 12);
	}

	@Override
	public FontUIResource getMenuTextFont() {
		return new FontUIResource(Font.SANS_SERIF, Font.PLAIN, 14);
	}

	@Override
	public FontUIResource getWindowTitleFont() {
		return new FontUIResource(Font.SANS_SERIF, Font.PLAIN, 12);
	}

	@Override
	public FontUIResource getSubTextFont() {
		return new FontUIResource(Font.SANS_SERIF, Font.PLAIN, 12);
	}

}
