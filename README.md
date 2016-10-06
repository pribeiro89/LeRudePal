# LeRudePal
App made for the Pixels Camp Hackaton

## Wiki
<strong>Command for sending request to Unbabel API:</strong>

<pre>
curl -H "Authorization: ApiKey username:apikey" -H "Content-Type: application/json" -X POST https://sandbox.unbabel.com/tapi/v2/mt_translation/ -d '{"text" : "Text_to_translate", "target_
language" : "en", "text_format" : "text"}'
</pre>
*"mt_translation" uses machine translation only.*
Answer to request comes in the form:
<pre>
{"origin": "api", "source_language": "pt", "status": "machine_translate_in_progress", "target_language": "en", "text": "cabrão", "text_format": "text", "uid": "7020203a4a"}
</pre>

<strong>Command for getting the answer from Unbabel API:</strong>

<pre>
curl -H "Authorization: ApiKey username:apikey" -H "Content-Type: application/json" -X GET https://sandbox.unbabel.com/tapi/v2/mt_translation/"uid"/
</pre>
*uid: uid from the answer to the request*

Answer to get request comes in the form:
<pre>
{"source_language": "pt", "status": "deliver_ok", "target_language": "en", "text": "cabrão", "text_format": "text", "translatedText": "bastard", "uid": "7020203a4a"}
</pre>


