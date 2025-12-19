package egovframework.com.edoc.clsf.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.com.cmm.ResponseCode;
import egovframework.com.cmm.service.ResultVO;
import egovframework.com.cmm.util.ResultVoHelper;
import egovframework.com.edoc.clsf.domain.model.DocumentClassificationSearchVO;
import egovframework.com.edoc.clsf.service.impl.DocumentClassificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "documentclassification")
@RequiredArgsConstructor
@Tag(name = "DocumentClassificationController", description = "회원 관리")
public class DocumentClassificationController {

	public static final String HEADER_STRING = "Authorization";

	private final EgovPropertyService propertyService;
	private final ResultVoHelper resultVoHelper;
	private final DocumentClassificationService documentClassificationService;

	@Operation(summary = "대분류 조회", description = "대분류 조회", tags = { "DocumentClassificationController" })
	@GetMapping("/toplevel")
	public ResultVO getTopLevel() {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("list", documentClassificationService.getTopLevelList());

		return resultVoHelper.buildFromMap(resultMap, ResponseCode.SUCCESS);
	}

	@Operation(summary = "하위분류 조회", description = "하위분류 조회", tags = { "DocumentClassificationController" })
	@Parameters({ @Parameter(name = "no", description = "문서분류코드 번호", required = true) })
	@GetMapping("/{no}/children")
	public ResultVO getChildren(@PathVariable("no") String no) {

		Map<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("list", documentClassificationService.getChildren(no));

		return resultVoHelper.buildFromMap(resultMap, ResponseCode.SUCCESS);
	}

	@Operation(summary = "문서분류 상세 조회", description = "문서분류 상세 조회", tags = { "DocumentClassificationController" })
	@Parameters({ @Parameter(name = "no", description = "문서분류코드 번호", required = true) })
	@GetMapping("/{no}")
	public ResultVO get(@PathVariable("no") String no) {

		Map<String, Object> resultMap = new HashMap<String, Object>();

		resultMap.put("detail", documentClassificationService.select(no));

		return resultVoHelper.buildFromMap(resultMap, ResponseCode.SUCCESS);
	}
	
	@Operation(
			summary = "문서분류 목록 조회",
			description = "문서분류 목록을 조회",
			security = {@SecurityRequirement(name = "Authorization")},
			tags = {"DocumentClassificationController"}
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "조회 성공"),
			@ApiResponse(responseCode = "403", description = "인가된 사용자가 아님")
	})
	
	@GetMapping(value ="/search")
	public ResultVO selectBBSUseInfs(HttpServletRequest request,
			@ModelAttribute DocumentClassificationSearchVO searchVO) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		searchVO.setPageUnit(propertyService.getInt("Globals.pageUnit"));
		searchVO.setPageSize(propertyService.getInt("Globals.pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
	    paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
	    paginationInfo.setPageSize(searchVO.getPageSize());

	    searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
	    searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
	    searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());


		paginationInfo.setTotalRecordCount(documentClassificationService.selectListTotCnt(searchVO));

	    resultMap.put("list", documentClassificationService.selectList(searchVO));
	    resultMap.put("paginationInfo", paginationInfo);

	    return resultVoHelper.buildFromMap(resultMap, ResponseCode.SUCCESS);
	}

}