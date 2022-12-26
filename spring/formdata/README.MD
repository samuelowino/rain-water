# Handling URL Encoded Form Data 

The most commonly used HTTP method for form submission is POST.

**HTTP GET** method can support *idempotent** form submissions.
For forms that use the GET method, the entire form data is sent as part of the query string.
**HTTP POST** supports single request form submission.
If you use POST, data is sent as part of the body of the HTTP request.

Moreover, in the latter case, we can also **specify the encoding of data with the form's *enctype** attribute, which can take two values, namely *application/x-www-form-urlencoded* and *multipart/form-data**.

## Media Type *application/x-www-form-urlencoded*

HTML forms have a default value of *application/x-www-form-urlencoded* for the **enctype attribute** as this takes care of basic use cases where data is entirely text. 

If your use case involves supporting file data, then you'll have to override it with a value of *multipart/form-data*.

Essentially, it sends the form data as key-value pairs separated by an **ampersand (&) character.
Also, the respective key and value are separated with the equal sign(=). 
Further, all reserved and non-alphanumeric characters are encoded using **percent-encoding**.




