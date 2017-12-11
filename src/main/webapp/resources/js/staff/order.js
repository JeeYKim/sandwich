// 빅타입이 변경될때 스몰타입 연동 
(function() {
//	var BigType = {
//			'빵': ["허니오트","위트","파마산","화이트"],
//			'야채': ["오이","토마토","피망","양파"],
//			'소세지': ["베이컨","햄","계란"],
//			'치즈': ["체다치즈"],
//			'소스': ["렌치드레싱","스위트칠리","핫칠리","머스타드"]
//		};
	
	var BigType = {};
	var sandwich;
	var sandwichs = JSON.parse(sandwichJsonStr);
	
	for(var i=0, len=sandwichs.length; i<len; i++) {
		sandwich = sandwichs[i];
		
		if(BigType[sandwich.bigType] === undefined) {
			BigType["" + sandwich.bigType] = [];
		}
		BigType[sandwich.bigType].push({
			smallType: sandwich.smallType,
			sandwichNo: sandwich.sandwichNo
		});
	}
	
	makeBigtypeSelect();
	
	$("#orderBigtype").on("change", onChangeBigType);
	
	function makeBigtypeSelect() {
		var html = "<OPTION value=''>---카테고리를 선택하세요---</OPTION>";
		var btype = [];
		
		// 빅타입 중복 방지 
		for(var i=0, len=sandwichs.length; i<len; i++) {
			if(btype.indexOf( sandwichs[i].bigType ) === -1) {
				btype.push(sandwichs[i].bigType);
			}
		}
		
		for(var i=0, len=btype.length; i<len; i++) {
			html += "<option value='" + btype[i] + "'>" +  btype[i] + "</option>";
		}
		
		$("#orderBigtype").empty().append(html);
		
	}
	
	function onChangeBigType(e) {
		var selVal = $(this).val();
		var smallType = BigType[selVal];
		var html = "<OPTION value=''>---재료 종류을 선택하세요---</OPTION>";
		
		for(var i=0, len=smallType.length; i<len; i++) {
			html += "<option value='" + smallType[i].smallType+ "'>" +  smallType[i].smallType + "</option>";
		}
		
		$("#orderSmalltype").empty().append(html);
	}
})();

function selectOrderBigtype(bigValue, smallValue) {
	$("#orderBigtype").val(bigValue).change();
	$("#orderSmalltype").val(smallValue);
}
