package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.domain.FlorEntity;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.dto.FlorDTO;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.repository.FlorRepository;

@Service
public class FlorServiceImpl implements FlorService {

	@Autowired
	private FlorRepository florRepository;

	@Override
	public void guardar(FlorEntity florEntity) {
		florRepository.save(florEntity);

	}

	@Override
	public List<FlorDTO> getAll() {

		List<FlorDTO> fDTO = new ArrayList<FlorDTO>();
		List<FlorEntity> flores = (List<FlorEntity>) florRepository.findAll();
		for (FlorEntity florEntity : flores) {
			fDTO.add(pasarASDto(florEntity));
		}

		return fDTO;
	}

	@Override
	public FlorEntity getOne(Integer id) {
		FlorEntity florEntity = new FlorEntity();
		florEntity = florRepository.findById(id).orElse(null);
		return florEntity;
	}

	@Override
	public void delete(Integer id) {
		florRepository.deleteById(id);

	}

	@Override
	public FlorDTO pasarASDto(FlorEntity florEntity) {
		FlorDTO florDTO = new FlorDTO();
		florDTO.setPk_florID(florEntity.getPk_florID());
		florDTO.setNomFlor(florEntity.getNomFlor());
		florDTO.setPaisFlor(florEntity.getPaisFlor());
		florDTO.setTipusFlor(florDTO.addTipus());
		return florDTO;
	}

}
