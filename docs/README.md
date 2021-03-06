Welcome to the Tachyon documentation!

This readme will walk you through navigating and building the Tachyon documentation, which is included here with the Tachyon source code. 

Read on to learn more about viewing documentation in plain text (i.e., markdown) or building the documentation yourself. Why build it yourself? So that you have the docs that corresponds to whichever version of Tachyon you currently have checked out of revision control.

## Generating the Documentation HTML

We include the Tachyon documentation as part of the source (as opposed to using a hosted wiki, such as the github wiki, as the definitive documentation) to enable the documentation to evolve along with the source code and be captured by revision control (currently git). This way the code automatically includes the version of the documentation that is relevant regardless of which version or release you have checked out or downloaded.

In this directory you will find textfiles formatted using Markdown, with an ".md" suffix. You can read those text files directly if you want. Start with index.md.

To make things quite a bit prettier and make the links easier to follow, generate the html version of the documentation based on the src directory by running `jekyll` in the docs directory. Use the command `SKIP_SCALADOC=1 jekyll` to skip building and copying over the scaladoc which can be timely. To use the `jekyll` command, you will need to have Jekyll installed, the easiest way to do this is via a Ruby Gem, see the [jekyll installation instructions](https://github.com/mojombo/jekyll/wiki/install). This will create a directory called _site containing index.html as well as the rest of the compiled files. Read more about Jekyll at https://github.com/mojombo/jekyll/wiki.

In addition to generating the site as html from the markdown files, jekyll can serve up the site via a webserver. To build and run a webserver use the command `jekyll --server` which (currently) runs the webserver on port 4000, then visit the site at http://localhost:4000.

## Pygments

We also use pygments (http://pygments.org) for syntax highlighting in documentation markdown pages, so you will also need to install that (it requires Python) by running `sudo easy_install Pygments`.

To mark a block of code in your markdown to be syntax highlighted by jekyll during the compile phase, use the following sytax:

    {% highlight scala %}
    // Your scala code goes here, you can replace scala with many other
    // supported languages too.
    {% endhighlight %}
