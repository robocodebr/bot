import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Bot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage();
        String txt = msg.getText();
        if(txt.equals("/start")){
            sendMessage(msg,"Hello");
        }else {
            sendMessage(msg, "null");
        }
    }

    public String getBotUsername() {
        return "weather1558_bot";
    }

    public String getBotToken() {
        return "2099158090:AAGgBHvmOKSlny1-rz-G_nsSGSjoJJnZCPw";
    }

    public static void main(String[] args){
        TelegramBotsApi telegramBotsApi = null;
        try {
            telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new Bot());
        }
        catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(Message msg, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(msg.getChatId().toString());
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
