//打印
function printit(){
	if (confirm('确定打印吗?'))
	{
		$("a").hide();
		 window.print();
	} 
}