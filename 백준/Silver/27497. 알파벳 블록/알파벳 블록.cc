#include <iostream>
#include <deque>
#include <stack>

using namespace std;

deque<char> dq;
stack<int> st;
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	//전체 횟수 입력
	int n;	cin >> n;
	//전체 횟수만큼 반복
	for (int i = 0; i < n; i++) {
		int pos; //문자열 추가 확인 변수
		char alphbet_block;	//추가할 문자열 변수
		// 문자열 추가 확인 입력
		cin >> pos;

		//문자열을 추가해야할 때
		if (pos < 3) {
			//문자열 입력
			cin >> alphbet_block;

			//문자열 맨 뒤에 블록 추가
			if (pos == 1) {
				dq.push_back(alphbet_block);
			}
			//문자열 맨 앞에 블록 추가
			else if (pos == 2) {
				dq.push_front(alphbet_block);
			}
			//문자열을 빼야 할 상황에 차례에 맞게 빼기위해 stack에 pos 저장
			st.push(pos);
		}
		//문자열을 삭제해야할 때
		else if(pos==3) {
			//저장된 문자가 있을 경우에만 실행
			if (!st.empty()) {
				int choice = st.top();
				st.pop();
				//저장된 deque안에 뒤에서 빼야 할 경우
				if (choice == 1) {
					dq.pop_back();
				}
				//저장된 dequq안에 앞에서 빼야 할 경우
				else if (choice == 2) {
					dq.pop_front();
				}
			}
		}
	}
	//저장된 문자열이 없다면 0 출력
	if (dq.empty()) { cout << 0; return 0; }
	else {
		//저장된 문자열이 있다면 최종 출력
		for (auto a : dq) {
			cout << a;
		}
	}
	return 0;
}

/*
첫째 줄에 버튼을 누른 횟수
1 c : 문자열 맨 뒤에 c가 적힌 블록 추가
2 c : 문자열 맨 앞에 c가 적힌 블록 추가
3 : 문자열을 구성하는 블록 중 가장 나중에 추가된 블록 제거
c는 알파벳 대문자 또는 소문자로 주어진다.
*/