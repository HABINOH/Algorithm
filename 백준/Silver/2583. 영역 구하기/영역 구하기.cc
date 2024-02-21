#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

int dist[102][102];
int vis[102][102];

int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };

vector<int> v;

int main() {
	int M, N, K;
	cin >> M >> N >> K;
	for (int i = 0; i < K; i++) {
		int x1, x2, y1, y2;
		cin >> x1 >> y1 >> x2 >> y2;
		for (int j = y1; j < y2; j++) {
			for (int k = x1; k < x2; k++) {
				dist[j][k] = 1;
			}
		}
	}
	int cnt = 0;
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			if (vis[i][j] || dist[i][j]) { continue; }
			queue<pair<int, int>> Q;
			vis[i][j] = 1;
			Q.push({ i,j });
			int size = 1;
			cnt++;
			while (!Q.empty()) {
				auto cur = Q.front(); Q.pop();
				for (int a = 0; a < 4; a++) {
					int x = cur.first + dx[a];
					int y = cur.second + dy[a];
					if (x < 0 || y < 0 || x >= M || y >= N) { continue; }
					if (vis[x][y] || dist[x][y]) { continue; }
					vis[x][y] = 1;
					Q.push({ x,y });
					size++;
				}
			}
			v.push_back(size);
		}
	}
	cout << cnt << '\n';
	sort(v.begin(), v.end());
	for (auto a : v) {
		cout << a << ' ';
	}
}