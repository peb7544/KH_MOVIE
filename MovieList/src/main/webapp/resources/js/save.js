
/* 개봉일 */
let releaseDt = document.getElementById("releaseDt");
let releaseDt2 = document.getElementById("releaseDt2");

releaseDt.addEventListener("change", function() {
	let str = releaseDt.value.replace(/-/g, '');
	
	console.log(releaseDt.value);
	
	releaseDt2.value = str;
});