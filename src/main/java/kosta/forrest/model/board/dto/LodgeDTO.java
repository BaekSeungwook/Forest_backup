package kosta.forrest.model.board.dto;

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
public class LodgeDTO {

	private String lodgeCode;
	private String lodgeName;
	private int lodgePrice;
	private String lodgeDetail;
	private String lodgeAddr;
	private String lodgeTel;
	private String lodgeWriter;
	private String lodgeFilename;
	
	private MultipartFile lodgeFile;
}
