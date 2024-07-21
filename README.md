# Update 5.0
- Added PlayerMove event
- Removed Support AuthMeReloaded (LoginEvent)
- Added Support 1.21
- ONLY SUPPORT 1.21 AND JDK 22

config.yml
```yaml
Switches:
  Events:
    Chat:
      CustomMessageIsEnabled: false
    JoinMessageIsEnabled: false
    QuitMessageIsEnabled: false


Events:
  Messages:
    JoinMessage: "&e{player} joined the game" #f
    QuitMessage: "&e{player} left the game"
    DeathMessages:
      World: "{player} выпал из мира"
      High place: "{player} разбился насмерть"
    ChatMessage: "<{player}> {message}"
  Other:
    PlayerJump: # Added 3.0
      Can: true
    PlayerSprinting: # Added 3.0
      Kill: false
    PlayerSneaking:
      Kill: false
    PlayerMove: # Added 5.0
      Can: true
```
