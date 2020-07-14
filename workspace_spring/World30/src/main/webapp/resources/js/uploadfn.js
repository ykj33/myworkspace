/**
 * 
 */
 
 		
		function getOriginalName(filename) {
			if (checkImage(filename)) {
				var idx = filename.indexOf("_"); // 첫 번째 언더바 찾기

				idx = filename.indexOf("_", idx + 1); // 첫 번째 찾은 언더바 다음부터 언더바 찾기
				return filename.substring(idx + 1);
			} else {
				var idx = filename.indexOf("_");
				return filename.substring(idx + 1); // original name
			}
		}

		function checkImage(filename) {
			var idx = filename.lastIndexOf(".");
			var format = filename.substring(idx + 1).toUpperCase();
			if (format == 'PNG' || format == 'JPG' || format == 'JPEG'
					|| format == 'GIF') {
				return true;
			} else {
				return false;
			}
		}

		

		function getImageLink(result) {
			if (checkImage(result)) {
				// 이미지 파일일 경우 s_만 제거
				// 선생님의 방법
				return result.substring(0, 12) + result.substring(14);
				// 내 방법
				// return result.replace("s_", "");
			} else {

				// 아닐 경우 그냥 반환
				return result;
			}
		}