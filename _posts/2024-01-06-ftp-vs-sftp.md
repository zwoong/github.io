---
layout: post
title: FTP vs SFTP
tags: [네트워크, FTP vs SFTP]
categories: [네트워크, FTP vs SFTP]
image:
  path: /assets/img/post/network/ftp-vs-sftp.png
  alt: ftp-vs-sftp
date: 2024-01-06 18:10 +0900
---

## FTP vs SFTP

FTP(파일 전송 프로토콜)와 SFTP(SSH 파일 전송 프로토콜)는 모두 **네트워크를 통해 파일을 전송하는 데 사용되는 프로토콜**이다. 그러나 보안과 사용하는 기본 기술 측면에서 둘은 크게 다르다.

### FTP(File Transfer Protocol)

FTP는 네트워크를 통해 클라이언트와 서버 간에 **파일을 전송하는 데 사용되는 가장 오래된 프로토콜** 중 하나이다.

- **표준 프로토콜**: IETF(Internet Engineering Task Force)에서 정의되었다.
- **포트 번호**: 일반적으로 **데이터 전송에는 TCP 포트 20**을 사용하고 **제어 명령에는 21**을 사용한다.
- **암호화 없음**: FTP는 **본질적으로 암호화를 제공하지 않는다**. 이는 인증을 위한 자격 증명(사용자 이름 및 비밀번호)을 포함한 데이터가 일반 텍스트로 전송되어 가로챌 수 있음을 의미한다.

#### FTP 동작 방식

- **Disk**: 파일 전송 프로세스 중에 파일을 쓰거나 읽는 저장 장치
- **User**: 그래픽 사용자 인터페이스나 명령줄 인터페이스를 통해 FTP 클라이언트와 상호 작용하는 사람
- **Client**: 사용자가 **FTP 서버에 연결하는 데 사용하는 기계 또는 소프트웨어**
  - **User Interface**: 사용자가 FTP 명령을 시작하기 위해 상호 작용하는 FTP 클라이언트의 일부
  - **Control process**: 명령을 보내고 응답을 받기 위해 FTP 서버에 대한 제어 연결을 관리하며, 제어 프로세스는 포트 21을 사용하여 **TCP/IP를 통해 서버의 제어 프로세스와 통신**한다.
  - **Data transfer process**: 실제 파일 전송을 처리한다.
- **TCP/IP**: 클라이언트와 서버 간 통신에 사용되는 프로토콜
- **Server** : 전송할 파일을 보관하고 FTP 서버 소프트웨어를 실행하는 시스템
  - **Control process**: 제어 연결을 통해 명령과 응답을 관리한다.
  - **Data transfer process**: 파일을 보내거나 받기 위해 클라이언트의 데이터 전송 프로세스와 데이터 연결을 관리한다.

![ftp-workflow](/assets/img/post/network/ftp-workflow.jpg){: width=＂700＂ }

### SFTP(SSH File Transfer Protocol)

SFTP는 **보안 파일 전송에 사용되는 최신 프로토콜**이다. 이는 SSH(Secure Shell) 프로토콜 제품군의 일부이다.

- **보안 전송**: 인증 자격 증명을 포함한 데이터는 **SSH를 사용하여 암호화되므로 제3자가 데이터를 가로채거나 읽을 수 없다**.
- **포트 번호**: 일반적으로 SSH와 같은 **TCP 포트 22를 사용**한다.
- **기능**: SFTP는 파일 전송 외에도 중단된 전송 재개, 원격 파일 제거 등 원격 파일에 대한 다양한 작업을 허용한다.
- **일반 텍스트 자격 증명 없음**: SFTP는 SSH의 일부이므로 **비밀번호를 일반 텍스트로 보낼 필요가 없는 강력한 인증 방법의 이점을 누릴 수 있다**. 또한 비밀번호 인증보다 더 안전한 공개 키 인증과 통합할 수도 있다.

![sftp](/assets/img/post/network/sftp.png){: width=＂700＂ }
