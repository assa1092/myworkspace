/**
 * 
 */
 
 function getImageLink(result){
			if(checkImage(result)){	
				return result.substring(0,12) + result.substring(14);
			} else {
				return result;
			}
			
		}
		

		// 이미지 파일이면 두번째...'_' 언더바
		// 이미지 파일이 아니면 첫번째.. _언더바에서 가져오면 파일이름 
		function getOriginalName(filename){
			if(checkImage(filename)){

				var idx = filename.indexOf("_");	// 첫번째 _언더바 의 인덱스를 찾아서
				
				idx = filename.indexOf("_", idx+1);	// 그 다음부터 다시 두번째 _ 를 찾아서
				return filename.substring(idx+1);	// 두번째 _언더바 그 다음부터의 값을 리턴해준다.
				
			} else {
				var idx = filename.indexOf("_");
				return filename.substring(idx+1);	// +1 을 해야 '_'언더바 다음부터 나온다. 
			}
		}


		// 이미지 파일 여부 확인
		function checkImage(filename){
			var idx = filename.lastIndexOf(".");
			
			var format = filename.substring(idx+1).toUpperCase();
			
			if(format =='PNG' || format == 'JPG'|| 
					format == 'JPEG'|| format == 'GIF'){
				return true;
			} else {
				return false;
			}
			
		}