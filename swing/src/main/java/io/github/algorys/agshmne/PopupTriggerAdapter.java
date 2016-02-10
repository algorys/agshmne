package io.github.algorys.agshmne;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public abstract class PopupTriggerAdapter extends MouseAdapter {

	public abstract void popupTrigger(MouseEvent e);
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.isPopupTrigger()) {
			popupTrigger(e);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.isPopupTrigger()) {
			popupTrigger(e);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.isPopupTrigger()) {
			popupTrigger(e);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.isPopupTrigger()) {
			popupTrigger(e);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.isPopupTrigger()) {
			popupTrigger(e);
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(e.isPopupTrigger()) {
			popupTrigger(e);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(e.isPopupTrigger()) {
			popupTrigger(e);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(e.isPopupTrigger()) {
			popupTrigger(e);
		}
	}

}
