---
layout: post
title: Git 설치 및 설정
tags: [Git, Git 설치 및 설정]
categories: [Git, Git 설치 및 설정]
image:
  path: /assets/img/post/git/git-setting.jpeg
  alt: git-setting
date: 2024-01-15 22:58 +0900
---

## Git 설치 방법

git 설정 방법은 글쓴이가 macOS를 사용하기 때문에 mac 기준으로 설명해 드리는 점 양해 부탁합니다. 😉 <br>
git 세팅에 앞서 먼저 macOS에서 제일 많이 사용되는 패키지 관리 시스템인 Homebrew에 대해 알아보자.

### Homebrew란?

Homebrew는 **오픈 소스 소프트웨어 패키지 관리 시스템**으로, Apple의 macOS 운영 체제 및 Linux에 소프트웨어를 간편하게 설치할 수 있다. (덕분에 패키지 관리가 정말 쉽다. )

#### Homebrew 대표적인 명령어

- **brew install [formula]**: 지정된 패키지를 설치한다. 예를 들어 brew install git은 git 패키지를 설치한다.
- **brew uninstall [formula]**: 시스템에서 지정된 패키지를 제거한다.
- **brew update**: Homebrew 자체를 업데이트하고 **사용 가능한 패키지 및 해당 버전의 최신 목록을 가져온다**. 설치된 패키지를 업그레이드하지는 않는다.
- **brew upgrade [formula]**: 해당 패키지를 최신 버전으로 업그레이드한다. 예를 들어 brew upgrade git은 git 패키지를 최신 버전으로 업그레이드한다.
- **brew list**: 설치된 모든 패키지를 나열한다.
- **brew outdated**: 설치된 패키지 목록 중 업데이트 버전이 존재하는 패키지들을 표시한다.
- **brew tap [repository]**: 새 저장소(탭)를 추가한다. **Homebrew에서 공식적으로 지원하지 않고, 일반적으로 커뮤니티나 제3자가 유지 관리하는 패키지를 설치할 때 사용**한다
- **brew untap [repository]**: 목록에서 저장소(탭)을 제거한다.
- **brew cask install [cask]**: 지정된 캐스크를 설치한다. macOS의 GUI 애플리케이션을 커맨드로 설치할 수 있도록 해주는 기능이다. 예를 들어 brew cask install google-chrome은 chrome 애플리케이션을 설치해준다.
- **brew cask uninstall [cask]**: 지정된 캐스크를 제거한다.
- **brew search [text]**: **주어진 텍스트와 일치하는 formula와 cask를 검색**한다.
- **brew cleanup**: Homebrew 패키지와 관련된 **오래되고 불필요한 파일을 제거해 디스코 공간을 확보**한다.

> Homebrew가 무엇인지와 대표적인 명령어에 대해 간단히 알아봤으니 이제 Homebrew를 통해 git을 설치해보자.

### Git 셋팅 절차

- **Homebrew 설치**

```console
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

- **Git 설치**

```console
brew install git
```

> 설치한 다음 아래 명령어를 통해 git 설치가 정상적으로 되었는지 확인해보자.

```console
brew search git

git ✔ # git이 검색되면 성공 :)
```

### Git 기본 설정 지정 (커밋 추적을 위해서)

- **사용자 이름 설정**

```console
git config --global user.name "Your Name"
```

- **이메일 설정**

```console
git config --global user.email "your_email@example.com"
```

#### Git에서는 인증과 커밋 추적이 별도로 처리된다.❗️

- **인증(토큰/키)**

  - 원격 저장소(예: GitHub, GitLab 또는 Bitbucket)와 상호 작용할 때 인증은 일반적으로 SSH 키 또는 개인 액세스 토큰을 사용하여 수행된다
    - **SSH 키**: SSH(Secure Shell) 키는 **서버에 안전하게 로그인하는 방법을 제공**하며 원격 저장소와 통신하는 데 사용된다.
    - **개인 액세스 토큰**: Git 인증의 비밀번호 대신 사용되며 저장소에 대한 보다 안전하고 유연한 액세스 방안이다.

- **추적 커밋(이메일 및 이름)**
  - Git의 **user.name 및 user.email 설정은 저장소 기록에서 특정 커밋을 수행한 사람을 식별하는 데 사용**된다.
  - 해당 정보는 **인증용이 아닌 어트리뷰션용으로 사용**된다. 이를 통해 누가 언제 어떤 변경을 했는지 다른 사람들에게 알릴 수 있다.

다음 포스팅에는 git에서 사용자 인증을 받는 방식에 대해서도 알아보자.
