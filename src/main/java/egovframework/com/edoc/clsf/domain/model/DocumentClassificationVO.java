package egovframework.com.edoc.clsf.domain.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "문서분류")
@Getter
@Setter
public class DocumentClassificationVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3067138537477155300L;

	@Schema(description = "문서분류 번호", example="")
	private String no;

	@Schema(description = "문서분류 구분코드", example="")
    private String divCode;

	@Schema(description = "문서분류명", example="")
    private String name = "";

	@Schema(description = "상위문서분류 번호", example="")
	private String parentNo;

	@Schema(description = "개인정보포함여부", example="")
    private String includingPrivacy ;

	@Schema(description = "사용유무", example="")
    private String use;

	@Schema(description = "등록일자")
    private Date created;

	@Schema(description = "등록자", example="")
    private String author;

	@Schema(description = "수정일자")
    private Date updated;

	@Schema(description = "수정자", example="")
    private String updateAuthor;
    /**
     * toString 메소드를 대치한다.
     */
    public String toString() {
	return ToStringBuilder.reflectionToString(this);
    }

}