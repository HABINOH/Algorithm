// Run by Node.js
const readline = require('readline');

let rl = readline.createInterface({ input: process.stdin, output: process.stdout });

const input = [];
rl.on('line', (line)=> {
	input.push(line);
}).on('close', () => {
	const [n,m] = input[0].split(" ").map(Number);
	
	const salt = (7 * n) / 100; // x= 소금
	
	const a = (salt / (m + n)) * 100;

	console.log((Math.floor(a * 100) / 100).toFixed(2))	
})