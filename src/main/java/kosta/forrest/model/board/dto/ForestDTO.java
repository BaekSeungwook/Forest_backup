package kosta.forrest.model.board.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ForestDTO {

	private int forestNo;
	private String forestName;
	private String forestType;
	private String forestFacil;
	private String forestAddr;
	private String forestTel;
	private String city;
	private String forestUrl;
	private double forestLatitude;
	private double forestLongitude;
	private String forestWriter;
	private String forestFilename;
	
	private MultipartFile forestFile;
	
	private List<LodgeDTO> lodgeList;
}
