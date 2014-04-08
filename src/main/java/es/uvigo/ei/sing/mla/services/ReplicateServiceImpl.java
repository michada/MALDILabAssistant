package es.uvigo.ei.sing.mla.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import es.uvigo.ei.sing.mla.daos.ReplicateDAO;
import es.uvigo.ei.sing.mla.model.entities.Replicate;
import es.uvigo.ei.sing.mla.model.entities.Sample;

@Service("sampleService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ReplicateServiceImpl implements ReplicateService {
	@Autowired
	ReplicateDAO dao;

	@Override
	public Replicate add(Replicate replicate) {
		return dao.add(replicate);
	}

	@Override
	public Replicate get(Integer id) {
		return dao.get(id);
	}

	@Override
	public Replicate update(Replicate replicate) {
		return dao.update(replicate);
	}

	@Override
	public void delete(Replicate replicate) {
		dao.delete(replicate);
	}

	@Override
	public List<Replicate> list(Sample sample) {
		return dao.list(sample);
	}
}
