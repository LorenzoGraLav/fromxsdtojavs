package it.prova.fromxsdtojavs.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import it.prova.fromxsdtojavs.model.AssicuratoModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlRootElement(name = "assicurato")
@XmlAccessorType(XmlAccessType.FIELD)
public class AssicuratiDTO {

	@XmlElement(name = "nome")
	private String nome;
	@XmlElement(name = "cognome")
	private String cognome;
	@XmlElement(name = "datadinascita")
	private String dataDiNascita;
	@XmlElement(name = "codicefiscale")
	private String codiceFiscale;
	@XmlElement(name = "numerosinistri")
	private int numeroSinistri;

	
	
	public AssicuratoModel buildAssicuratoModel() {
		AssicuratoModel result = AssicuratoModel.builder().nome(this.nome).cognome(this.cognome).dataDiNascita(this.dataDiNascita)
				.codiceFiscale(this.codiceFiscale).numeroSinistri(this.numeroSinistri).build();

		return result;
	}
	
	public List<AssicuratoModel> buildAssicuratoModelFromList(List < AssicuratiDTO > modelListInput) {
		return modelListInput.stream().map(assicuratoEntity -> {
			AssicuratoModel result = assicuratoEntity.buildAssicuratoModel();
			return result;
		}).collect(Collectors.toList());
	}
	public List<AssicuratiDTO> buildAssicuratoDTOFromModelList(List < AssicuratoModel > modelListInput) {
		return modelListInput.stream().map(assicuratoEntity -> {
			AssicuratiDTO result = AssicuratiDTO.buildAssicuratoDTOFromModel(assicuratoEntity);
			return result;
		}).collect(Collectors.toList());
	}
	
	public static AssicuratiDTO buildAssicuratoDTOFromModel(AssicuratoModel assicuratoModel) {

		AssicuratiDTO result = AssicuratiDTO.builder().nome(assicuratoModel.getNome())
				.cognome(assicuratoModel.getCognome()).codiceFiscale(assicuratoModel.getCodiceFiscale())
				.dataDiNascita(assicuratoModel.getDataDiNascita()).numeroSinistri(assicuratoModel.getNumeroSinistri()).build();
		return result;
	}


}
