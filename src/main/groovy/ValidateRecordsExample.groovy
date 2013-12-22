import main.groovy.Config

Config config = new Config()
assert config.factory != null

def session = config.factory.currentSession
def tx = session.beginTransaction()

def books = session.createQuery("from Book").list()
println 'Found ' + books.size() + ' books'