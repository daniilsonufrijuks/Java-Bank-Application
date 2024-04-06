from mailersend import emails
from dotenv import load_dotenv
import os

def send():
    load_dotenv()

    mailer = emails.NewEmail(os.getenv('mlsn.13b8ebc4ce704c2e43a1ead6dac9ef778ffe77b1291461ad8ecf8e1e481bfc64'))

    # define an empty dict to populate with mail values
    mail_body = {}

    mail_from = {
        "name": "...",
        "email": "monolithabout@gmail.com",
    }

    recipients = [
        {
            "name": "Your Client",
            "email": "kroshthebestfriend@gmail.com",
        }
    ]

    # reply_to = {
    #     "name": "Name",
    #     "email": "reply@domain.com",
    # }

    mailer.set_mail_from(mail_from, mail_body)
    mailer.set_mail_to(recipients, mail_body)
    mailer.set_subject("Hello!", mail_body)
    mailer.set_html_content("This is the HTML content", mail_body)
    mailer.set_plaintext_content("This is the text content", mail_body)
    # mailer.set_reply_to(reply_to, mail_body)

    # using print() will also return status code and data
    mailer.send(mail_body)

def main():
    send()

main()