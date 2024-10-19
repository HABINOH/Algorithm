#include<iostream>
#include<queue>
#include<algorithm>
#include<tuple>
using namespace std;

bool InRange(int x, int y);
void bfs(int x, int y);

int N;	//N x N 
int L, R; //L 이상 R 이하만 인구이동

int country[51][51];
bool vis[51][51];

int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };

bool check = true;

int result;

int main() {
	//인구 입력
	cin >> N >> L >> R;
	//나라 간 인구 입력
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> country[i][j];
		}
	}
	while (check) {
		check = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!vis[i][j]) { bfs(i, j); }
			}
		}
		if (!check) break;
		for (int i = 0; i < N; i++) { fill(vis[i], vis[i] + N, false); }
		result++;
	}

	cout << result;

	return 0;
}

bool InRange(int x, int y) {
	return x < 0 || y < 0 || x >= N || y >= N;
}

void bfs(int x, int y) {
	int peple_avg = 0;
	int cnt = 0;
	pair<int, int> temp[2501];
	queue<pair<int, int>> q;
	q.push({ x,y });
	vis[x][y] = true;

	peple_avg = country[x][y];
	temp[cnt++] = make_pair(x, y);

	while (!q.empty()) {
		auto cur = q.front(); q.pop();
		
		for (int i = 0; i < 4; i++) {
			int nx = cur.first + dx[i];
			int ny = cur.second + dy[i];

			if (InRange(nx, ny)) { continue; }
			if (vis[nx][ny]) { continue; }

			int comp = country[cur.first][cur.second] - country[nx][ny];

			if (L <= abs(comp) && R >= abs(comp)) {
				check = true;
				q.push({ nx,ny });
				peple_avg += country[nx][ny];
				temp[cnt++] = make_pair(nx, ny);
				vis[nx][ny] = true;
			}
		}
	}
	peple_avg /= cnt;

	for (int i = 0; i < cnt; i++) {
		int tx, ty;
		tie(tx, ty) = temp[i];
		country[tx][ty] = peple_avg;
	}

}