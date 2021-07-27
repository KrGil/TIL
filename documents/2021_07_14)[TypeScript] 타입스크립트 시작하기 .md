# [TypeScript] 타입스크립트 시작하기

# TypeScript?

- 언어 (javaScript 기반의  compiled(transpile) 언어 *javascript는 interpreted)
- superset

> Compiled

- 컴파일러가 필요, 컴파일 시점이 존재
- 컴파일 하는 과정에서 type을 캐치함.

> 정적타입  |  동적 타입 언어.

- javascript는 동적 타입 언어. 정적 타입의 장점만을 가지고 와보자고 한 것이
- typescirpt

# Node.js 설치

- [https://nodejs.org](https://nodejs.org)

> 폴더 내에 typescript 설치하기

설치 후 terminal을 실행시켜 설치하고자 하는 folder에 들어가 typescript를 설치합니다.

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_07_13/Untitled.png?raw=true)
```jsx
Eisen@Changui-MacBook typescript-basic-tsc % npm init -y
Wrote to /Users/Eisen/Documents/GitHub/typescript-basic/typescript-basic-tsc/package.json:

{
  "name": "typescript-basic-tsc",
  "version": "1.0.0",
  "description": "",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "keywords": [],
  "author": "",
  "license": "ISC"
}

npm notice
npm notice New minor version of npm available! 7.15.1 -> 7.19.1
npm notice Changelog: https://github.com/npm/cli/releases/tag/v7.19.1
npm notice Run npm install -g npm@7.19.1 to update!
npm notice
Eisen@Changui-MacBook typescript-basic-tsc % npm i typescript

added 1 package, and audited 2 packages in 3s

found 0 vulnerabilities
Eisen@Changui-MacBook typescript-basic-tsc % ls
node_modules		package-lock.json	package.json
Eisen@Changui-MacBook typescript-basic-tsc %
```

- 이렇게 typescript-basic-tsc 폴더 안에 typescript를 설치할 수 있음.

```jsx
// vscode 실행
Eisen@Changui-MacBook typescript-basic-tsc % code .
```

![alt text](https://github.com/KrGil/TIL/blob/main/documents/2021_07_13/Untitled1.png?raw=true)
이렇게 scirpts 부분에 transpile을 입력해 줍니다.

**.bin 내부에 존재하는 파일은 경로를 따로 써주지 않아도 됩니다.

> 실행

```jsx
**Eisen@Changui-MacBook typescript-basic-tsc % .node_modules/.bin/tsc test.ts**
```

로 실행할 수 있습니다.

> global로 설치하기

- terminal을 킨 후

```jsx
npm i typescript -g
```

- 설치 후

```jsx
**Eisen@Changui-MacBook typescript-basic-tsc % tsc test.ts**
```

- 경로를 따로 주지 않아도 실행할 수 있습니다.
