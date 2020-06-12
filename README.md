# PeyangSuperbAntiCheat（略称：PSAC）
Bukkit / Spigot / PaperMC のプラグインです。
1.12.2で動作確認/絶賛開発中です（たぶん）

このプラグインは、Bukkit / Spigot / PaperMC サーバーで使用できる、**チートレポート管理** / **チートテスト**プラグインです。

また、ハックと言う読み方は実際に（Minecraft）サーバーをハッキング（クラッキング）しません。
そのため、この README ではハックをあえてチートと呼んでいます。  
↑ごめん＾＾；  
**ご理解のほど、よろしくお願いします。**

## インストール方法

+ 適当にダウンロードします
+ [ProtocolLib](https://www.spigotmc.org/resources/protocollib.1997/)[(\*)](https://dev.bukkit.org/projects/protocollib) を plugins フォルダに入れます。  
+ このプラグインを plugins フォルダに入れます。
+ 再起動して、適用してください。

## コマンド
### /wdr
Hypixel の**~~パクリ~~**コマンドです。
#### 説明
「こんなものをつかってるぷれいやーがいるよ！みてみて！」
っていうコマンドです。
##### 運営側サイド
プレイヤーからのレポートは、2形式で表示されます。  
「\[PeyangSuperbAntiCheat\] プレイヤーがレポートを提出しました！クリックしてレポートを確認してください！ \[CLICK\]」  
と  
「\[STAFF\] \[ADMIN\] Fishy: Report of \<PlayerName\> \<理由1\>, \[理由2\]...」  
の形で表示されます。コンフィグを編集することにより、変更できます。

このモードは、<details><summary>█████</summary>Kam7</details>によって**リークされた** Hypixel Lynx Mod との互換性をもたせるモードです。  
この Mod は、Hypixel では Bannable であり、この Mod を使用したまま、Hypixel には、**絶対に**行かないでください。
Hypixel から BAN されます。
#### 使用法
+ /wdr \<PlayerName\>
この状態で実行すると、本が開きます。
この本の文字をクリックすると、理由が追加されます。

- ![#008000](https://via.placeholder.com/15/008000/000000?text=+) **緑太字**の文字をクリックで送信するか、
- ![#ff0000](https://via.placeholder.com/15/ff0000/000000?text=+) **赤太字**の文字をクリックで破棄します。

**注意：このプラグインでは超原始的な本の実装方法を使用しています。**

+ /wdr \<PlayerName\> \<理由1\> \[理由2\]...
これは、本を開かずにそのまま理由を入力して、報告する方法です。
本を開かないため、**意味を感じられませんが**、コンソールからでも報告できます。
#### 報告に使用できる理由一覧
##### 本で表示される順に書きます。
| 理由 | エイリアス | 簡単な説明 |
|:-:|:-:|-|
| Fly | flight | プレイヤーが空を飛べるようにできるチートです。 |
| KillAura | killaura, aura, ka | 範囲に入った人をより早く攻撃することができるチートです。 |
| AutoClicker | autoclicker, ac, autoclick | 自動で左クリックを可能にするチートです。 |
| Speed | speed, bhop, timer | ありえない速度で歩くことができるチートです。（Bunnyhop や、Timer は Speed に値します） |
| AntiKnockback | akb, velocity, antikb | 攻撃を受けても一切ノックバックしないチートです。。 |
| Reach | reach | 攻撃できる距離を伸ばすことができるチートです。 |
| Dolphin | dolphin | イルカのように、水を自動で泳ぐチートです。 |

###### 同じ人から同じ人への報告はできないようになっています。報告スパム防止です。

#### 権限
``` psr.report ``` です。
初期では、全員持ってる権限です。

### /aurabot

#### 説明
このコマンドを実行すると、プレイヤーの周りにプレイヤーの周囲を回る NPC を召喚します。  
この NPC は、特定の速度でプレイヤーの周りを回り、特定の回数叩かれた場合プレイヤーをキックします。  

#### 使用法
##### /aurabot \<PlayerName\>
\<PlayerName\> に指定されたプレイヤーに、回るNPCを召喚します。
#### 権限
``` psr.mod ``` です。  
### /acpanic
#### 説明
このコマンドを実行すると、プレイヤーの背後にへばりつくように NPC を指定された秒数召喚します。  
#### 使用法
##### /acpanic \<PlayerName\> \[seconds\]
\<PlayerName\> に指定されたプレイヤーに \[seconds\] で指定された秒数、背後にNPCを召喚します。
#### 権限
``` psr.mod ``` です。
### /peyangsuperbanticheat
#### エイリアス
+ /psac
+ /psr
etc…
#### 説明
このプラグインのメインコマンドです。引数をつけることによって動作します。
#### 引数一覧
##### /psac help
このプラグインコマンドのヘルプを表示します。
``` psac.mod ``` または ``` psac.admin ``` 権限を持っている人には、以下のヘルプも表示されます。
##### /psac view \[ページ数\]
プレイヤーが提出したレポートを確認することができます。
脅威度順に5件ずつ表示されます。
##### /psac show \<管理ID\>
プレイヤーが提出したレポートの詳細を表示します。
このコマンドをプレイヤーから実行すると、本が開き、報告の詳細を確認することができます。
コンソールから実行した場合、コンソールにそのまま表示されます。
##### /psac drop \<管理ID\>
プレイヤーが提出した報告を**完全**に破棄します。
ログなども残らずに消えます。**ご注意ください。**
##### /psac kick \<PlayerName\> \[test\]
\<PlayerName\>で指定したプレイヤーをキックします。
第2引数に``` test ``` を指定すると、テストモードでキックされます。  
## キックについて
このプラグインでは誤検出などのためにプレイヤーが 誤BAN されることを危惧しています。
そのため、自動BAN はこのプラグインには含まれません。
### ブロードキャストメッセージについて
**プレイヤーがキックされるとき、以下のブロードキャストメッセージが流れます。**  

「\[PEYANG CHEAT DETECTION\] ハッキング、または不適切な発言によってゲームからプレイヤーが削除されました。」
「違反行為をしたプレイヤーをゲームから対処しました。ご報告ありがとうございました！」

このメッセージは、チートを自動検出した時のメッセージです。  
スタッフによるキックの場合は、「違反行為をしたプレイヤーをゲームから対処しました。ご報告ありがとうございました！」だけが流れます。  
### キック理由について
キックの理由は以下の通りです。
#### PEYANG ANTI CHEAT DETECTION
このプラグインが自動で検知した場合のメッセージです。
#### KICKED BY STAFF
スタッフによるキックコマンドです。
### PEYANG ANTI CHEAT TEST
このプラグインのテストです。
## NPC について
現NPCは、[@randomapi](https://twitter.com/randomapi)によるAPI「[RandomUserGenerator](https://randomuser.me/)」を使用して、  
ランダムなユーザ名をもつプレイヤーを召喚します。  
スキンはランダムですが。現段階では、コンフィグに登録されたUUIDのスキンのみがランダム表示されます。
## コンフィグについて
このプラグインでは、以下のコンフィグを使用しています。適当に変えてください。
| 設定名 | デフォルト値 | 説明 |
|:-:|:-:|-|
| database.path | ./eye.db | レポート情報などを保存するSQLiteのデータベースの置き場所です。 |
| database.logPath | ./log.db | キック情報などを保存するSQLiteのデータベースの置き場所です。 |
| npc.seconds | 6                                                           | NPCが回る時間です。 |
| npc.bump | 30.0                          | NPC が途中で落ちてしまったり、動きが止まってしまった場合などに、適度に増やす値です。 |
| npc.time | 0.2 | NPC が回る速さです。感覚で調整してください。 |
| npc.range | 2.1 | NPC が回る半径です。 |
| npc.kill | 3                             | NPCを出す数です。この場合では、10秒間に3キルを表します。 |
| kick.delay | 2                   | プレイヤーをキックするまでの遅延です。ブロードキャストされた瞬間から数えられます。 |
| kick.lightning | true | プレイヤーがキックされるときに（エフェクトだけの）雷を落とすかどうかです。 |
| kick.defaultKick | 40 | 学習済データが見つからないとき、この回数NPCを殴ると、Kickされます。 |
| message.lynx | true | リークされた Mod「Lynx」と互換性を保たせるかどうかです。 |
| skins | \(省略\) | NPC に適用するスキンです。この中からランダムで選ばれます。 |
# AI もどきについて
このプラグインでは、クソ雑魚ナメクジゴミAIとよばれる、AI**もどき**があります。
実際のチートを用いて学習させることにより、キックの精度が向上する… **（と思って作ったものです）**
~~実際、意味は皆無でした。~~
# 謝辞
このプラグインは、以下のライブラリ / API を使用しています。  
[brettwooldridge](https://github.com/brettwooldridge/)氏 [HikariCP](https://github.com/brettwooldridge/HikariCP)  
[dmulloy2](https://github.com/dmulloy2/)氏 [ProtocolLib](https://www.spigotmc.org/resources/protocollib.1997/) [(\*)](https://dev.bukkit.org/projects/protocollib)  
[jedk1](https://www.spigotmc.org/members/jedk1.43536/)氏 [BookUtil.java](https://www.spigotmc.org/threads/resource-bookutil-1-8-1-9.131549/)  
[DarkBlade12](https://github.com/DarkBlade12/)氏 [ReflectionUtils.java](https://github.com/DarkBlade12/ParticleEffect/blob/master/src/main/java/com/darkblade12/particleeffect/ReflectionUtils.java)  
