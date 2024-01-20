---
layout: post
title: Git 변경사항 추적
tags: [Git, Git 변경사항 추적]
categories: [Git, Git 변경사항 추적]
image:
  path: /assets/img/post/git/git.png
  alt: git
date: 2024-01-20 11:11 +0900
---

> 이번 시간에는 Github에서 직접 repository(저장소)를 만들어보고 local에 clone 시킨 후 기본적인 Git 명령어를 사용하는 방법을 알아보자. 😉

## repository(저장소)

GitHub의 저장소는 **프로젝트가 존재하는 저장 공간 역할**을 하며, 여기에는 폴더와 모든 유형의 파일(예: HTML, CSS, JavaScript, 문서, 데이터, 이미지)이 포함될 수 있다.

- **저장소 탭 오른쪽 위에 New 버튼을 클릭한다.**
  ![repository-create-button](/assets/img/post/git/repository-create-button.png){: width=＂700＂ }
- **저장소에 대한 설정을 한 이후 Create repository 버튼을 클릭한다.**
  - **저장소 이름**: 저장소의 고유한 이름을 입력한다.
  - **설명(선택 사항)**: 저장소에 대한 간단한 설명을 제공한다.
  - **가시성**: 저장소가 공개(누구나 저장소를 보고 포크할 수 있음)인지 비공개(특정 사람만 저장소에 기여할 수 있음)인지 선택한다.
  - **다음을 사용하여 저장소를 초기화한다.**
    - **README 파일 추가**: README는 프로젝트를 소개하고 설명하는 문서이다.
    - **.gitignore 추가**: **특정 파일과 폴더가 버전 제어에 추가되는 것을 방지**한다.
    - **라이센스 선택**: 라이센스는 다른 사람들이 저장소에 코드로 무엇을 할 수 있고 할 수 없는지 알려준다. 어떤 것을 선택해야 할지 확실하지 않은 경우 나중에 라이선스를 검토하면 된다.
      ![repository-create](/assets/img/post/git/repository-create.png){: width=＂700＂ }
- **저장소 생성완료**
  ![repository-created](/assets/img/post/git/repository-created.png){: width=＂700＂ }
- **저장소를 로컬 머신에 복제한다.**
  - Code 탭을 누른 후 동그라미 표기 부분을 눌러 clone에 사용 가능한 URL을 복사한다.
    ![repository-clone](/assets/img/post/git/repository-clone.png){: width=＂700＂ }
  - 터미널에서 명령어 실행
    ```console
      git clone [repository URL]
    ```

## 기본적인 Git 명령어

- **변경 내용 추적**
  - **git add**
    - **목적**: **작업 디렉터리의 변경 사항을 준비 영역에 추가**한다. 이는 Git에게 다음 커밋에 특정 파일에 대한 업데이트를 포함하고 싶다고 알려준다.
    - **사용법**: 특정 파일을 추가하려면 git add [file]을 입력하고 모든 변경 사항을 추가하려면 `git add .`를 입력한다.
    - **공통 옵션**
      - `.`: 현재 디렉터리와 하위 디렉터리의 모든 변경 사항(새 파일, 수정, 삭제 포함)을 추가한다.
      - `-u`: 새 파일은 무시하고 수정 및 삭제만 추가한다.
  - **git commit**
    - **목적**: 변경 사항을 가져와 설명 메시지와 함께 저장소에 커밋한다.
    - **사용법**: `git commit -m "Commit message"`를 입력하여 변경 사항을 설명하는 메시지와 함께 커밋한다.
    - **공통 옵션**
      - `-m "message"`: 커밋 메시지를 인라인으로 포함한다.
      - `--amend`: 가장 최근 커밋을 수정하고 변경 사항을 추가한다.
  - **git push**
    - **목적**: 로컬 저장소 콘텐츠를 원격 저장소에 업로드한다.
    - **사용법**: git push [remote-name] [branch-name]을 입력하여 변경 사항을 푸시한다. **[remote-name]은 origin(Git이 복제한 원격지에 부여하는 기본 이름)인 경우가 많으며**, [branch-name]은 푸시하려는 브랜치이다. git push를 입력하고 현재 로컬 브랜치가 동일한 이름을 가진 원격 브랜치를 추적하고 있다면 Git은 푸시할 위치를 자동으로 알 수 있다. (clone을 할때 remote-name도 자동으로 가져오므로 git push 명령어를 사용할때 매번 원격 이름과 브랜치를 지정하지 않고도 변경 사항을 푸시할 수 있음)
    - **공통 옵션**
      - `--all`: 모든 브랜치를 원격 저장소로 푸시한다.
      - `--force 또는 -f`: fast-forward merge(추후 브랜치 관리 전략 포스팅에서 다룰 예정)가 아닌 경우에도 강제로 푸시한다. 이 옵션은 원격 저장소의 변경 사항을 덮어쓸 수 있으므로 주의해야 한다.
      - `--delete`: 원격 분기를 삭제한다. 원격 저장소에서 브랜치를 제거하려는 경우 이 옵션을 사용할 수 있다.
  - **git status**
    - **목적**: 작업 디렉터리와 준비 영역의 상태를 표시한다. 이를 통해 어떤 변경 사항이 준비되었는지, 어떤 변경 사항이 준비되지 않았는지, 어떤 파일이 Git에서 추적되지 않는지 확인할 수 있다.

![git-commit-workflow](/assets/img/post/git/git-commit-workflow.png){: width=＂700＂ }
