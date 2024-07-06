#include <iostream>

using namespace std;
typedef long long ll;

int n, k;
int	a[10005];

bool solution(ll x) {
	ll cur = 0;
	for (int i = 0; i < k; i++) { cur += a[i] / x; }
	return cur >= n;
}

int main() {
	cin >> k >> n;
	for (int i = 0; i < k; i++) { cin >> a[i]; }
	ll st = 1;
	ll en = 0x7fffffff; // 2^31 - 1 = 16진수
	while (st < en) {
		ll mid = (st + en + 1) / 2;
		if (solution(mid)) { st = mid; }
		else { en = mid - 1; }
	}
	cout << st;

}