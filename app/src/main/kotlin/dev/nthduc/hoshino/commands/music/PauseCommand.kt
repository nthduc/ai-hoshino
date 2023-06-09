package dev.nthduc.hoshino.commands.music

import dev.kord.core.event.interaction.ButtonInteractionCreateEvent
import dev.kord.core.event.message.MessageCreateEvent
import dev.nthduc.hoshino.commands.Command
import dev.schlaubi.lavakord.LavaKord
import dev.schlaubi.lavakord.audio.Link

class PauseCommand(private val lavalink: LavaKord) : Command {
    override suspend fun execute(event: MessageCreateEvent) {
        val link = lavalink.getLink(event.guildId?.toString() ?: return)
        if (link.state == Link.State.CONNECTED) {
            link.player.pause()
            event.message.channel.createMessage("Đã tạm dừng phát nhạc !")
        } else {
            event.message.channel.createMessage("Not currently playing a track")
        }
    }
    suspend fun execute(event: ButtonInteractionCreateEvent) {
        val link = lavalink.getLink(event.interaction.data.guildId.value?.toString() ?: return)
        if (link.state == Link.State.CONNECTED) {
            link.player.pause()
            event.interaction.channel.createMessage("Đã tạm dừng phát nhạc !")
        } else {
            event.interaction.channel.createMessage("Not currently playing a track")
        }
    }

    override val description: String
        get() = "Pause playing track"
}
