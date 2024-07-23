# [Gold IV] Maximum Subset - 21040 

[문제 링크](https://www.acmicpc.net/problem/21040) 

### 성능 요약

메모리: 35616 KB, 시간: 420 ms

### 분류

이분 탐색, 매개 변수 탐색, 정렬

### 제출 일자

2024년 7월 23일 17:18:03

### 문제 설명

<p>Let us define the value of a multiset of integers is the minimum difference between any two distinct elements. If a multiset contains two elements with the same value, then the two elements are considered different elements thus the value of the multiset is 0.</p>

<p>Given a multiset of integers <em>A</em> consisting of <em>N</em> elements, we want to find the value of the subset of <em>A</em> consisting of <em>K</em> elements which has the maximum value.</p>

### 입력 

 <p>The first line contains two integers: <em>N</em> <em>K</em> (2 ≤ <em>K</em> ≤ <em>N</em> ≤ 100,000) in a line denoting the number of elements of <em>A</em> and the number of elements of the subset of <em>A</em> we are looking for. The second line contains <em>N</em> integers: <em>A</em><sub>1</sub>, <em>A</em><sub>2</sub>, ..., <em>A<sub>N</sub></em> (0 ≤ <em>A<sub>i</sub></em> ≤ 1,000,000,000) representing the elements of set <em>A</em>.</p>

### 출력 

 <p>The output contains the value of the subset of <em>A</em> consisting of <em>K</em> elements which has the maximum value, in a line.</p>

