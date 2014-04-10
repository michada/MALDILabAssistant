package es.uvigo.ei.sing.mla.view.models;

import java.util.Observable;
import java.util.Observer;

import javax.swing.event.ListDataEvent;

import org.zkoss.zul.AbstractListModel;

import es.uvigo.ei.sing.mla.model.entities.Replicate;
import es.uvigo.ei.sing.mla.model.entities.Sample;

public class SampleListModel extends AbstractListModel<Replicate> implements Observer {
	private static final long serialVersionUID = 1L;
	
	private final Sample sample;
	
	public SampleListModel(Sample sample) {
		this.sample = sample;
		this.sample.addObserver(this);
	}
	
	public Sample getSample() {
		return sample;
	}

	@Override
	public Replicate getElementAt(int index) {
		return this.sample.getReplicates().get(index);
	}

	@Override
	public int getSize() {
		return this.sample.getReplicates().size();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof Replicate) {
			final Replicate condition = (Replicate) arg;
			
			try {
				if (this.sample.getReplicates().contains(condition)) {
					// Replicate was added
					final int index = this.sample.getReplicates().indexOf(condition);
					
					this.fireEvent(ListDataEvent.INTERVAL_ADDED, index, index);
				} else {
					// Replicate was removed
					this.fireEvent(ListDataEvent.CONTENTS_CHANGED, -1, -1);
				}
			} catch (Exception e) {
				// List model is not associated with any desktop
				o.deleteObserver(this);
			}
		}
	}
}
