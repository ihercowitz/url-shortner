# Clojure URL Shortner
How does bit.ly, tinyurl or google generates that small URLS?

This project shows how to do this in a very simple way using Clojure. So all the entries are stored on a Atom and they're lose when you close the repl.

## News
- Compojure and Ring libs has been added to the project.
- This Shortner is published on Heroku


## Usage

- lein repl
- (url-short *your-url*) <-- this will create a random entry on the url atom and associate this with the desire url
- (url-unshort *short-value*)  <-- this will reveal the shorted link

URL:
http://clshortme.herokuapp.com/s?url= *your-url*
This will generate a short version of your link

http://clshortme.herokuapp.com/ *short-link*
This will redirect you to the previous shortened URL

## Known bugs:
- URLs with # aren't well shortned

## License
Copyright © 2014
