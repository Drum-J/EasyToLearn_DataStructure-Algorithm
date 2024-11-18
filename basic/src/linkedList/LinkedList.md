### 연결 리스트

---

자료구조를 만들 때 주의해야 할 점

>1. Empty Data Structure (자료 구조가 비어있는 경우)
>2. Single element in the Data Structure (단 하나의 요소만 들어있는 경우)
>3. Adding / removing beginning of Data Structure (첫번째 요소를 제거하거나 추가할 경우)
>4. Adding / removing end of Data Structure (마지막 요소를 제거하거나 추가할 경우)
>5. Working in the middle (중간 부분을 처리할 경우) - 가장 흔한 경우라고 한다.

---

### 연결 리스트의 추상자료형
> 1. 모든 데이터 출력 / printAll();
> 2. 모든 데이터 제거 / clear();
> 3. 인덱스 삽입 / insertAt(index,data);
> 4. 마지막 삽입 / insertLast(data);
> 5. 인덱스 삭제 / deleteAt(index);
> 6. 마지막 삭제 / deleteLast();
> 7. 인덱스 읽기 / getNodeAt(index):

---

읽기에도 first, last 를 추가로 구현했다.