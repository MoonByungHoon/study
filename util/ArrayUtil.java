package util;

public class ArrayUtil {
//	배열의 길이 값 계산.
	public static int size(int[] arr) {
		
		return arr.length;
	}

//	배열이 데이터를 가지고 있는지 체크.
	public static boolean isEmpty(int[] arr) {
		
		return size(arr) == 0;
	}

//	배열에 있는 특정 인덱스 값 리턴
	public static int get(int[] arr, int index) {
		
		return arr[index];
	}

//	배열에 특정 요소가 있는지 체크
	public static boolean contains(int[] arr, int element) {
		for (int i = 0; i < size(arr); i++) {
			if (get(arr, i) == element) {
				
				return true;
			}
		}

		return false;
	}

	public static int indexOf(int[] arr, int element) {
		for (int i = 0; i < size(arr); i++) {
			if (get(arr, i) == element) {
				return i;
			}
		}

		return -1;
	}

	public static int lastIndexOf(int[] arr, int element) {
		for (int i = size(arr) - 1; i >= 0; i--) {
			if (get(arr, i) == element) {
				return i;
			}
		}

		return -1;
	}

//	배열에 새로운 요소를 추가 그리고 크기가 증가한 배열을 리턴

	public static int[] add(int[] arr, int element) {

//		1. 현재 배열보다 크기가 1 더 큰 int[]을 만들어준다.
		int[] temp = new int[size(arr) + 1];

//		2. 현재 배열의 내용을 차례대로 임시 배열에 넣어준다.
		for (int i = 0; i < size(arr); i++) {
			temp[i] = get(arr, i);
		}

//		3. 임시 배열의 가장 마지막 칸에 element를 넣어준다.
		temp[size(temp) - 1] = element;

//		4. 임시 배열을 리턴한다.
		return temp;
	}
	
//	배열에 원하는 칸에 값을 밀어넣기
	public static int[] add(int[] arr, int index, int element) {
		int[] temp = new int[0];
		
		for(int i = 0; i < index; i++) {
			temp = add(temp, get(arr, i));
		}
		
		temp = add(temp, element);
		
		for(int i = index; i < size(arr); i++) {
			temp = add(temp, get(arr, i));
		}
		
		return temp;
	}
	
//	지정한 index에 값 변경
	public static int set(int[] arr, int index, int element) {
		int temp = get(arr, index);
		arr[index] = element;
		
		return temp;
	}
	
//	지정한 index 삭제
	public static int[] removeByIndex(int[] arr, int index) {
		if(index < 0 || index >= size(arr)) {
			return arr;
		}
		
		int[] temp = new int[0];
		
		for(int i = 0; i < size(arr); i++) {
			if(i != index) {
				temp = add(temp, get(arr, i));
			}
		}
		
		return temp;
	}
	
//	같은 element 값을 가진 index 삭제
	public static int[] removeByElement(int[] arr, int element) {
		
		return removeByIndex(arr, indexOf(arr, element));
	}
	
//	2. String
	
//	A. size
	public static int size(String[] arr) {
		return arr.length;
	}
//	B. isEmpty
	public static boolean isEmpty(String[] arr) {
		return size(arr) == 0;
	}
//	C. get
	public static String get(String[] arr, int index) {
		return arr[index];
	}
//	D. contains
	public static boolean contains(String[] arr, String e) {
		for(int i = 0; i < size(arr); i++) {
			if(get(arr, i).equals(e)) {
			
				return true;
			}
		}
		
		return false;
	}
//	E.indexOf
	public static int indexOf(String[] arr, String e) {
		for(int i = 0; i < size(arr); i++) {
			if(get(arr, i).equals(e)) {
				
				return i;
			}
		}
		
		return -1;
	}
//	F.lastIndexOf
	public static int lastIndexOf(String[] arr, String e) {
		for(int i = size(arr) - 1; i >= 0; i--) {
			if(get(arr, i).equals(e)) {
				
				return i;
			}
		}
		
		return -1;
	}
//	G. add
	public static String[] add(String[] arr, String e) {
		String[] temp = new String[size(arr) + 1];
		
		for(int i = 0; i < size(arr); i++) {
			temp[i] = get(arr, i);
		}
		temp[size(temp) - 1] = e;
		
		return temp;
	}
//	H. add
	public static String[] add(String[] arr, int index, String e) {
		String[] temp = new String[0];
		
		for(int i = 0; i < index; i++) {
			temp = add(temp, get(arr, i));
		}
		
		temp = add(temp, e);
		
		for(int i = index; i < size(arr); i++) {
			temp = add(temp, get(arr, i));
		}
		
		return temp;
	}
//	I. set
	public static String set(String[] arr, int index, String e) {
		String temp = get(arr, index);
		
		arr[index] = e;
		
		return temp;
	}
//	J. remove
	public static String[] remove(String[] arr, int index) {
		if(index < 0 || index >= size(arr)) {
			return arr;
		}
		
		String[] temp = new String[0];
		
		for(int i = 0; i < size(arr); i++) {
			if(i != index) {
				temp = add(temp, get(arr, i));
			}
		}
		
		return temp;
	}
//	K. remove
	public static String[] remove(String[] arr, String e) {
		return remove(arr, indexOf(arr, e));
	}
}