package study;

import util.ArrayUtil;

public class lotto_study {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[3];

		arr[0] = 3;
		arr[1] = 2;
		arr[2] = 20;

		System.out.println("Array size : " + ArrayUtil.size(arr));

		System.out.println("isEmpty : " + ArrayUtil.isEmpty(arr));

		System.out.println("get : " + ArrayUtil.get(arr, 1));

		System.out.println("contains : " + ArrayUtil.contains(arr, 20));
		System.out.println("contains : " + ArrayUtil.contains(arr, 30));
		
		System.out.println("indexOf " + ArrayUtil.indexOf(arr, 20));
		System.out.println("indexOf " + ArrayUtil.indexOf(arr, 30));
		
		System.out.println("lastIndexOf " + ArrayUtil.lastIndexOf(arr, 20));
		System.out.println("lastIndexOf " + ArrayUtil.lastIndexOf(arr, 30));
		
		System.out.println("add 전 size : " + ArrayUtil.size(arr));
		
		arr = ArrayUtil.add(arr, 50);
		
		System.out.println("add 후 size : " + ArrayUtil.size(arr));
		System.out.println("add 후 contiains : " + ArrayUtil.contains(arr, 50));
		
		System.out.println("add 전 size : " + ArrayUtil.size(arr));
		System.out.println("add 전 get : " + ArrayUtil.get(arr, 2));
		
		arr = ArrayUtil.add(arr, 2, 99);
		
		System.out.println("add 후 size : " + ArrayUtil.size(arr));
		System.out.println("add 후 get : " + ArrayUtil.get(arr, 2));
		
		System.out.println("set 전 get : " + ArrayUtil.get(arr, 2));
		
		int temp = ArrayUtil.set(arr, 2, 88);
		
		System.out.println("set 후 get : " + ArrayUtil.get(arr, 2));
		System.out.println("set 전 기존 값 : " + temp);
		
		System.out.println("remove 전 size : " + ArrayUtil.size(arr));
		System.out.println("remove 전 indexOf : " + ArrayUtil.indexOf(arr, 88));
		
		arr = ArrayUtil.removeByIndex(arr, 2);
		
		System.out.println("remove 후 size : " + ArrayUtil.size(arr));
		System.out.println("remove 후 indexOf : " + ArrayUtil.indexOf(arr, 88));
		
		System.out.println("remove 전 size : " + ArrayUtil.size(arr));
		System.out.println("remove 전 indexOf : " + ArrayUtil.indexOf(arr, 50));
		
		arr = ArrayUtil.removeByElement(arr, 50);
		
		System.out.println("remove 후 size : " + ArrayUtil.size(arr));
		System.out.println("remove 후 indexOf : " + ArrayUtil.indexOf(arr, 50));
		

	}
}
