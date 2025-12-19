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
public class PrvcFileHldPrstVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6239302856645724370L;

	@Schema(description = "doc_clsf_no", example = "")
	private String docClsfNo;
	
	@Schema(description = "prvc_file_hld_prst_no", example = "")
	private String prvcFileHldPrstNo;
	
	@Schema(description = "dept_nm", example = "")
	private String deptNm;
	
	@Schema(description = "file_nm", example = "")
	private String fileNm;
	
	@Schema(description = "hld_prps", example = "")
	private String hldPrps;
	
	@Schema(description = "clct_stt_bss_expln", example = "")
	private String clctSttBssExpln;
	
	@Schema(description = "use_dept_nm", example = "")
	private String useDeptNm;
	
	@Schema(description = "prvc_prcs_mthd_expln", example = "")
	private String prvcPrcsMthdExpln;
	
	@Schema(description = "hld_prd_dfyrs", example = "")
	private Integer hldPrdDfyrs;
	
	@Schema(description = "hld_prd_mm_cnt", example = "")
	private Integer hldPrdMmCnt;
	
	@Schema(description = "info_mnbd_prvc_mttr", example = "")
	private String infoMnbdPrvcMttr;
	
	@Schema(description = "stty_agt_prvc_mttr", example = "")
	private String sttyAgtPrvcMttr;
	
	@Schema(description = "rrno_clct_yn", example = "")
	private String rrnoClctYn;
	
	@Schema(description = "rrno_clct_stt_bss_expln", example = "")
	private String rrnoClctSttBssExpln;
	
	@Schema(description = "info_mnbd_agre_yn", example = "")
	private String infoMnbdAgreYn;
	
	@Schema(description = "info_mnbd_dsag_clct_stt_bss_expln", example = "")
	private String infoMnbdDsagClctSttBssExpln;
	
	@Schema(description = "sens_info_hld_yn", example = "")
	private String sensInfoHldYn;
	
	@Schema(description = "sens_info_indiv_agre_yn", example = "")
	private String sensInfoIndivAgreYn;
	
	@Schema(description = "sens_info_hld_stt_bss_expln", example = "")
	private String sensInfoHldSttBssExpln;
	
	@Schema(description = "uii_hld_yn", example = "")
	private String uiiHldYn;
	
	@Schema(description = "uii_indiv_agre_yn", example = "")
	private String uiiIndivAgreYn;
	
	@Schema(description = "uii_hld_stt_bss_expln", example = "")
	private String uiiHldSttBssExpln;
	
	@Schema(description = "prvc_evl_trgt_yn", example = "")
	private String prvcEvlTrgtYn;
	
	@Schema(description = "hndl_pic_nm", example = "")
	private String hndlPicNm;
	
	@Schema(description = "tdpty_splrcp_nm", example = "")
	private String tdptySplrcpNm;
	
	@Schema(description = "tdpty_pvsn_bss_expln", example = "")
	private String tdptyPvsnBssExpln;
	
	@Schema(description = "tdpty_pvsn_mttr", example = "")
	private String tdptyPvsnMttr;
	
	@Schema(description = "prvc_prcs_cnsgn_bzenty_nm", example = "")
	private String prvcPrcsCnsgnBzentyNm;
	
	@Schema(description = "prvc_cnsgn_ctrt_yn", example = "")
	private String prvcCnsgnCtrtYn;
	
	@Schema(description = "prvc_cnsgn_fact_indct_yn", example = "")
	private String prvcCnsgnFactIndctYn;
	
	@Schema(description = "prps_excl_utztn_pvsn_yn", example = "")
	private String prpsExclUtztnPvsnYn;
	
	@Schema(description = "prps_excl_utztn_pvsn_bss_expln", example = "")
	private String prpsExclUtztnPvsnBssExpln;
	
	@Schema(description = "reg_ymd", example = "")
	private Date regYmd;
	
	@Schema(description = "rgtr_id", example = "")
	private String rgtrId;
	
	@Schema(description = "mdfcn_ymd", example = "")
	private Date mdfcnYmd;
	
	@Schema(description = "mdfr_id", example = "")
	private String mdfrId;

	/**
	 * toString 메소드를 대치한다.
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}