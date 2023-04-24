function checkForm(obj){   // obj=this=form
   if(obj.irum.value==""){
      alert("이름을 입력하세요");
      obj.irum.focus();
      return false;
   }

   if(obj.siteUrl.value==""){
      alert("이동할 사이트를 선택하세요");
      obj.siteUrl.focus();
      return false;
   }

   var test=false;
   for(var i=0; i < obj.fruit.length; i++){
      if(obj.fruit[i].checked==true){
         test=true;
      }
   }

   if(test==false){
      alert("좋아하는 과일을 반드시 체크하세요");
      return false;
   }

   var str="";
   for(var i=0;i<obj.interest.length;i++){
      if(obj.interest[i].checked==true){
         str += obj.interest[i].value + ",";
      }
   } 
   if(str==""){
      alert("관심사를 하나 이상 체크하세요");
      return false;
   }

   // alert(str);
   obj.abc.value=str;
}