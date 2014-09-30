# Clojure URL Shortner
How does bit.ly, tinyurl or google generates that small URLS?

This project shows how to do this in a very simple way using Clojure. So all the entries are stored on a Atom and they're lose when you close the repl.

## Usage

- lein repl
- (url-short *your-url*) <-- this will create a random entry on the url atom and associate this with the desire url
- (url-unshort *short-value*)  <-- this will reveal the shorted link

## License
Copyright © 2014
