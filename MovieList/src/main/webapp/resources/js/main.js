
/*목록 상세보기*/
/*function listClickFn(memberNo) {
	
	const listId = document.getElementById("list_" + memberNo);
	
	console.log(listId);

	if(listId.style.display != 'none') listId.style.display = 'none';
	
	else listId.style.display = 'contents';
	
}*/

function listClickFn(element) {
	
    var before = document.getElementsByClassName("active")[0]               // 기존에 활성화된 버튼
    
    if (before && document.getElementsByClassName("active")[0] != element) {  // 자신 이외에 이미 활성화된 버튼이 있으면
        before.nextElementSibling.style.display = 'none';   // 기존에 펼쳐진 내용 접고
        before.classList.remove("active");                  // 버튼 비활성화
    }
    element.classList.toggle("active");         // 활성화 여부 toggle

	
    var content = element.nextElementSibling;
    if (content.style.display != 'none') {         // 버튼 다음 요소가 펼쳐져 있으면
        content.style.display ='none';         // 접기
    } else {
        content.style.display = 'contents';    // 접혀있는 경우 펼치기
    }
}